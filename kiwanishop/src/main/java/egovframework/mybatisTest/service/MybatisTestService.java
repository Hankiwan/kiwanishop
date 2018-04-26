package egovframework.mybatisTest.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface MybatisTestService {

	public List<MybatisTestVO> mybatisTest(MybatisTestVO mybatisTestVO) throws Exception;
}
