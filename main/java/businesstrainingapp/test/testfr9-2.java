import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public void testGetSupportResponse_Success() throws Exception {
SupportResponse expectedResponse = new SupportResponse("Your request
is being processed. We will get back to you shortly.");
when(supportService.getSupportResponse(1L)).thenReturn(expectedResponse);
mockMvc.perform(MockMvcRequestBuilders.get("/support/1"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(
"Your request is being processed. We will get back to you shortly."));
verify(supportService).getSupportResponse(1L);
}
}