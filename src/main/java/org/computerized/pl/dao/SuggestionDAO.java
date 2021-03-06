package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.comment.CommentVO;
import org.computerized.pl.model.paging.PagingVO;
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

    public List<SuggestionListVO> loadSuggestionList(PagingVO pagingVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startIdx", (pagingVO.getNowPage() - 1) * pagingVO.getRowPerPage());
        param.put("rowBound", pagingVO.getRowPerPage());

        return sqlSession.selectList("suggestion.loadSuggestionList", param);
    }

    public Integer getTotalRowCount() {
        List<Integer> list = sqlSession.selectList("suggestion.getTotalRowCount");
        return list.get(0);
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

    public void increaseViews(Integer suggestionId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("suggestionId", suggestionId);
        sqlSession.update("suggestion.increaseViews", param);
    }

    public List<SuggestionListVO> searchSuggestion(String searchKey, PagingVO pagingVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startIdx", (pagingVO.getNowPage() - 1) * pagingVO.getRowPerPage());
        param.put("rowBound", pagingVO.getRowPerPage());
        param.put("searchKey", "%" + searchKey + "%");

        return sqlSession.selectList("suggestion.loadSuggestionList", param);
    }

    public Integer getTotalRowCountForSearch(String searchKey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("searchKey", "%" + searchKey + "%");

        List<Integer> list = sqlSession.selectList("suggestion.getTotalRowCountForSearch", param);
        return list.get(0);
    }

    public List<CommentVO> loadComment(Integer suggestionId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("suggestionId", suggestionId);
        return sqlSession.selectList("suggestionComment.loadComment", param);
    }

    public CommentVO loadCommentById(Integer commentId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("commentId", commentId);

        List<CommentVO> commentVOList = sqlSession.selectList("suggestionComment.loadCommentById", param);

        if(commentVOList.size() == 0)
            return null;

        return commentVOList.get(0);
    }

    public void addComment(CommentVO commentVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("suggestionId", commentVO.getPostId());
        param.put("contents", commentVO.getContents());
        param.put("writer", commentVO.getWriterId());

        sqlSession.insert("suggestionComment.addComment", param);
    }

    public void modComment(CommentVO commentVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("commentId", commentVO.getId());
        param.put("contents", commentVO.getContents());

        sqlSession.update("suggestionComment.modComment", param);
    }

    public void delComment(Integer commentId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("commentId", commentId);
        sqlSession.delete("suggestionComment.delComment", param);
    }
}
