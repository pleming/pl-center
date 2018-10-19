package org.computerized.pl.service;

import org.apache.commons.codec.binary.Base64;
import org.computerized.pl.dao.NoticeDAO;
import org.computerized.pl.model.image.ImageVO;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.notice.NoticePostVO;
import org.computerized.pl.model.notice.NoticeVO;
import org.computerized.pl.model.paging.PagingVO;
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
public class NoticeService {
    @Autowired
    private NoticeDAO noticeDAO;

    public List<NoticeListVO> loadNoticeList(PagingVO pagingVO) {
        return noticeDAO.loadNoticeList(pagingVO);
    }

    public Integer getTotalRowCount() {
        return noticeDAO.getTotalRowCount();
    }

    public NoticeVO loadNoticeById(Integer noticeId) {
        return noticeDAO.loadNoticeById(noticeId);
    }

    public void addNotice(HttpSession httpSession, NoticePostVO noticePostVO) {
        noticeDAO.initAddNotice(noticePostVO);
        parseImgTag(httpSession, noticePostVO);
        noticeDAO.ConfirmPostNotice(noticePostVO);
    }

    public void modNotice(HttpSession httpSession, NoticePostVO noticePostVO) {
        deleteImageFiles(httpSession, noticePostVO);
        parseImgTag(httpSession, noticePostVO);
        noticeDAO.ConfirmPostNotice(noticePostVO);
    }

    public void delNotice(HttpSession httpSession, NoticePostVO noticePostVO) {
        noticeDAO.delNotice(noticePostVO);
        deleteImageFiles(httpSession, noticePostVO);
    }

    public void increaseViews(Integer noticeId) {
        noticeDAO.increaseViews(noticeId);
    }

    public List<NoticeListVO> searchNotice(String searchKey) {
        return noticeDAO.searchNotice(searchKey);
    }


    private void deleteImageFiles(HttpSession httpSession, NoticePostVO noticePostVO) {
        String directoryPath = "/resources/uploads/notice/" + noticePostVO.getNoticeId();
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

    private void parseImgTag(HttpSession httpSession, NoticePostVO noticePostVO) {
        List<ImageVO> imageVOList = noticePostVO.getImageList();
        Document doc = Jsoup.parse(noticePostVO.getContents());
        Elements elements = doc.select("img");

        try {
            for (Element element : elements) {
                for (int i = 0; i < imageVOList.size(); i++) {
                    ImageVO imageVO = imageVOList.get(i);
                    String filename = imageVO.getFilename();

                    if (element.attr("alt").equals(filename)) {
                        String directoryPath = "/resources/uploads/notice/" + noticePostVO.getNoticeId();
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

        noticePostVO.setContents(doc.select("body").html());
    }
}
