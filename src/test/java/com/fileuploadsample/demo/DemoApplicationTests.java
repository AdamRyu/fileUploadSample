package com.fileuploadsample.demo;

import com.fileuploadsample.demo.model.FileInfo;
import com.fileuploadsample.demo.model.FileInfoRepository;
import com.fileuploadsample.demo.service.UploadFileService;
import com.fileuploadsample.demo.service.UploadFileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.tools.tree.UplevelReference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Before
	public void setupMock(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldGetAllFiles(){
		FileInfoRepository mockFileInfoRepository = mock(FileInfoRepository.class);
		List<FileInfo> list = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			list.add(new FileInfo(String.valueOf(i)));
		}
		when(mockFileInfoRepository.findAll()).thenReturn(list);
		Iterator<FileInfo> iterator = mockFileInfoRepository.findAll().iterator();
		int cnt = 0;
		while(iterator.hasNext()){
			cnt++;
			iterator.next();
		}
		assertEquals(cnt, 5);
	}

	@Test
	public void shouldGetOneFile(){
		FileInfoRepository mockFileInfoRepository = mock(FileInfoRepository.class);
		FileInfo mockFileInfo = new FileInfo("mockOneFile");
		when(mockFileInfoRepository.findById(1l)).thenReturn(mockFileInfo);
		UploadFileService mockUplevelReference = new UploadFileServiceImpl(mockFileInfoRepository);
		assertEquals("mockOneFile", mockUplevelReference.getFileInfo(1l).getNameForUser());
	}


}
