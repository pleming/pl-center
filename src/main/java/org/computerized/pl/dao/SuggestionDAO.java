package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.suggestion.SuggestionListVO;
import org.computerized.pl.model.suggestion.SuggestionPostVO;
import org.computerized.pl.model.suggestion.SuggestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SuggestionDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<SuggestionListVO> loadSuggestionList() {
        return sqlSession.selectList("suggestion.loadSuggestionList");
    }

    public SuggestionVO loadSuggestionById(Integer suggestionId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("suggestionId", suggestionId);

        List<SuggestionVO> suggestionVOList = sqlSession.selectList("suggestion.loadSuggestionById", param);

        if (suggestionVOList.size() == 0)
            return new SuggestionVO();

        return suggestionVOList.get(0);
    }

    public void initAddSuggestion(SuggestionPostVO suggestionPostVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("title", suggestionPostVO.getTitle());
        param.put("contents", "temp");
        param.put("writer", suggestionPostVO.getWriter());

        sqlSession.insert("suggestion.initAddSuggestion", param);
        suggestionPostVO.setSuggestionId((Integer) param.get("suggestionId"));
    }

    public void ConfirmPostSuggestion(SuggestionPostVO suggestionPostVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("suggestionId", suggestionPostVO.getSuggestionId());
        param.put("title", suggestionPostVO.getTitle());
        param.put("contents", suggestionPostVO.getContents());

        sqlSession.update("suggestion.ConfirmPostSuggestion", param);
    }

    public void delSuggestion(SuggestionPostVO suggestionPostVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("suggestionId", suggestionPostVO.getSuggestionId());
        sqlSession.update("suggestion.delSuggestion", param);
    }

    public List<SuggestionListVO> searchSuggestion(String searchKey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("searchKey", "%" + searchKey + "%");
        return sqlSession.selectList("suggestion.loadSuggestionList", param);
    }
}
