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
@WebMvcTest(CancelRegistrationController.class)
public class CancelRegistrationControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private RegistrationService registrationService;
@Test
public void testCancelRegistration_Success() throws Exception {
when(registrationService.cancelRegistration(1L,
1L)).thenReturn("Registration canceled successfully");
mockMvc.perform(MockMvcRequestBuilders.post("/cancelRegistration")
.contentType(MediaType.APPLICATION_JSON)
.param("userId", "1")
.param("trainingId", "1"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Registrati
on canceled successfully"));
verify(registrationService).cancelRegistration(1L, 1L);
}
}