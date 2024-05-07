import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;
@WebMvcTest(TrainingRegistrationController.class)
public class TrainingRegistrationControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private TrainingService trainingService;
@Test
public void testRegisterForTraining_Success() throws Exception {
when(trainingService.isRegistrationAllowed(1L, 1L)).thenReturn(true);
mockMvc.perform(MockMvcRequestBuilders.post("/registerTraining")
.param("trainingId", "1")
.param("userId", "1"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Успешная
регистрация на тренинг"));
}
10
@Test
public void testRegisterForTraining_Failure_NotAllowed() throws Exception
{
when(trainingService.isRegistrationAllowed(2L,
2L)).thenReturn(false);
mockMvc.perform(MockMvcRequestBuilders.post("/registerTraining")
.param("trainingId", "2")
.param("userId", "2"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Регистраци
я на тренинг невозможна"));
}
}