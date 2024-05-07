import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@WebMvcTest(SupportController.class)
public class SupportControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private SupportService supportService;
@Test
public void testSubmitSupportRequest_Success() throws Exception {
SupportRequest supportRequest = new SupportRequest("John Doe",
"john@example.com", "This is a test request");
when(supportService.submitRequest(supportRequest)).thenReturn("Request
submitted successfully");
mockMvc.perform(MockMvcRequestBuilders.post("/support")
.contentType(MediaType.APPLICATION_JSON)
.content("{\"name\":\"John Doe\",\"email\":
\"john@example.com\",\"message\":\"This is a test request\"}"))
.andExpect(MockMvcResultMatchers.status().isOk())