package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.notice.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NoticeDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<NoticeListVO> loadNoticeList() {
        return sqlSession.selectList("notice.loadNoticeList");
    }

    public NoticeVO loadNoticeById(Integer noticeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("noticeId", noticeId);

        List<NoticeVO> noticeVOList = sqlSession.selectList("notice.loadNoticeById", param);

        if(noticeVOList.size() == 0)
            return new NoticeVO();

        return noticeVOList.get(0);
    }
}
