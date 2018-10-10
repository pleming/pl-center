package org.computerized.pl.service;

import org.apache.commons.codec.binary.Base64;
import org.computerized.pl.dao.SuggestionDAO;
import org.computerized.pl.model.image.ImageVO;
import org.computerized.pl.model.suggestion.SuggestionListVO;
import org.computerized.pl.model.suggestion.SuggestionPostVO;
import org.computerized.pl.model.suggestion.SuggestionVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class SuggestionService {
    @Autowired
    private SuggestionDAO suggestionDAO;

    public List<SuggestionListVO> loadSuggestionList() {
        return suggestionDAO.loadSuggestionList();
    }

    public SuggestionVO loadSuggestionById(Integer suggestionId) {
        return suggestionDAO.loadSuggestionById(suggestionId);
    }

    public void addSuggestion(HttpSession httpSession, SuggestionPostVO suggestionPostVO) {
        suggestionDAO.initAddSuggestion(suggestionPostVO);
        parseImgTag(httpSession, suggestionPostVO);
        suggestionDAO.ConfirmPostSuggestion(suggestionPostVO);
    }

    public void modSuggestion(HttpSession httpSession, SuggestionPostVO suggestionPostVO) {
        deleteImageFiles(httpSession, suggestionPostVO);
        parseImgTag(httpSession, suggestionPostVO);
        suggestionDAO.ConfirmPostSuggestion(suggestionPostVO);
    }

    public void delSuggestion(HttpSession httpSession, SuggestionPostVO suggestionPostVO) {
        suggestionDAO.delSuggestion(suggestionPostVO);
        deleteImageFiles(httpSession, suggestionPostVO);
    }

    public List<SuggestionListVO> searchSuggestion(String searchKey) {
        return suggestionDAO.searchSuggestion(searchKey);
    }

    private void deleteImageFiles(HttpSession httpSession, SuggestionPostVO suggestionPostVO) {
        String directoryPath = "/resources/uploads/suggestion/" + suggestionPostVO.getSuggestionId();
        String directoryRealPath = httpSession.getServletContext().getRealPath(directoryPath);

        deleteFiles(directoryRealPath);
    }

    private void deleteFiles(String path) {
        File fileObj = new File(path);
        File[] files = fileObj.listFiles();

        if (files == null)
            return;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile())
                files[i].delete();
            else
                deleteFiles(files[i].getPath());
        }

        fileObj.delete();
    }

    private void parseImgTag(HttpSession httpSession, SuggestionPostVO suggestionPostVO) {
        List<ImageVO> imageVOList = suggestionPostVO.getImageList();
        Document doc = Jsoup.parse(suggestionPostVO.getContents());
        Elements elements = doc.select("img");

        try {
            for (Element element : elements) {
                for (int i = 0; i < imageVOList.size(); i++) {
                    ImageVO imageVO = imageVOList.get(i);
                    String filename = imageVO.getFilename();

                    if (element.attr("alt").equals(filename)) {
                        String directoryPath = "/resources/uploads/suggestion/" + suggestionPostVO.getSuggestionId();
                        String directoryRealPath = httpSession.getServletContext().getRealPath(directoryPath);
                        String filePath = directoryPath + "/" + filename;
                        String fileRealPath = directoryRealPath + "/" + filename;
                        String base64FullData = imageVO.getBase64Data();
                        String base64Data = base64FullData.substring(base64FullData.indexOf(",") + 1);
                        byte[] imageDataBytes = Base64.decodeBase64(base64Data);

                        File directoryPathObj = new File(directoryRealPath);

                        if (!directoryPathObj.exists())
                            directoryPathObj.mkdirs();

                        FileOutputStream imageOutFile = new FileOutputStream(fileRealPath);
                        imageOutFile.write(imageDataBytes);
                        imageOutFile.close();

                        element.attr("src", filePath);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        suggestionPostVO.setContents(doc.select("body").html());
    }
}
