package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.notice.NoticePostVO;
import org.computerized.pl.model.notice.NoticeVO;
import org.computerized.pl.model.paging.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NoticeDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<NoticeListVO> loadNoticeList(PagingVO pagingVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startIdx", (pagingVO.getNowPage() - 1) * pagingVO.getRowPerPage());
        param.put("rowBound", pagingVO.getRowPerPage());

        return sqlSession.selectList("notice.loadNoticeList", param);
    }

    public Integer getTotalRowCount() {
        List<Integer> list = sqlSession.selectList("notice.getTotalRowCount");
        return list.get(0);
    }

    public NoticeVO loadNoticeById(Integer noticeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("noticeId", noticeId);

        List<NoticeVO> noticeVOList = sqlSession.selectList("notice.loadNoticeById", param);

        if (noticeVOList.size() == 0)
            return new NoticeVO();

        return noticeVOList.get(0);
    }

    public void initAddNotice(NoticePostVO noticePostVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("title", noticePostVO.getTitle());
        param.put("contents", "temp");
        param.put("writer", noticePostVO.getWriter());

        sqlSession.insert("notice.initAddNotice", param);
        noticePostVO.setNoticeId((Integer) param.get("noticeId"));
    }

    public void ConfirmPostNotice(NoticePostVO noticePostVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("noticeId", noticePostVO.getNoticeId());
        param.put("title", noticePostVO.getTitle());
        param.put("contents", noticePostVO.getContents());

        sqlSession.update("notice.ConfirmPostNotice", param);
    }

    public void delNotice(NoticePostVO noticePostVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("noticeId", noticePostVO.getNoticeId());
        sqlSession.update("notice.delNotice", param);
    }

    public void increaseViews(Integer noticeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("noticeId", noticeId);
        sqlSession.update("notice.increaseViews", param);
    }

    public List<NoticeListVO> searchNotice(String searchKey, PagingVO pagingVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("startIdx", (pagingVO.getNowPage() - 1) * pagingVO.getRowPerPage());
        param.put("rowBound", pagingVO.getRowPerPage());
        param.put("searchKey", "%" + searchKey + "%");

        return sqlSession.selectList("notice.loadNoticeList", param);
    }

    public Integer getTotalRowCountForSearch(String searchKey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("searchKey", "%" + searchKey + "%");

        List<Integer> list = sqlSession.selectList("notice.getTotalRowCountForSearch", param);
        return list.get(0);
    }
}
