import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.verify;
@WebMvcTest(MaterialController.class)
public class MaterialControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private MaterialService materialService;
@Test
public void testUploadMaterial_Success() throws Exception {
MockMultipartFile file = new MockMultipartFile("file", "test.txt",
"text/plain", "Test file content".getBytes());
mockMvc.perform(MockMvcRequestBuilders.multipart("/materials")
.file(file))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Material
uploaded successfully"));
verify(materialService).uploadMaterial(file);
}
}