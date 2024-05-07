import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
16
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.verify;
@WebMvcTest(TrainingUpdateController.class)
public class TrainingUpdateControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private TrainingService trainingService;
@Test
public void testUpdateTraining_Success() throws Exception {
mockMvc.perform(MockMvcRequestBuilders.put("/updateTraining")
.param("trainingId", "1")
.param("title", "Updated Training")
.param("description", "Updated description of the training"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Training
updated successfully"));
verify(trainingService).updateTraining(1L, "Updated Training",
"Updated description of the training");
}
}