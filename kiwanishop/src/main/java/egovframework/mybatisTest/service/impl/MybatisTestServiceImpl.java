package egovframework.mybatisTest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mybatisTest.service.MybatisTestService;
import egovframework.mybatisTest.service.MybatisTestVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("mybatisTestService")
public class MybatisTestServiceImpl extends AbstractServiceImpl implements 
			MybatisTestService {

	/** MybatisTestDAO */
	@Resource(name="mybatisTestMapper")
	private MybatisTestMapper mybatisTestMapper;
	
	public List<MybatisTestVO> mybatisTest(MybatisTestVO mybatisTestVO) throws Exception{
		return mybatisTestMapper.mybatisTest(mybatisTestVO);
	}
	
	
}
