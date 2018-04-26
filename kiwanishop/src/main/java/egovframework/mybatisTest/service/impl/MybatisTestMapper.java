package egovframework.mybatisTest.service.impl;

import java.util.List;

import egovframework.mybatisTest.service.MybatisTestVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("mybatisTestMapper")
public interface MybatisTestMapper {

	 public List<MybatisTestVO> mybatisTest(MybatisTestVO mybatisTestVO) throws Exception;
	
}
