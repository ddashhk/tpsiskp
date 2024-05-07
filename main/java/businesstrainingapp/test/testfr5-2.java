import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.verify;
@WebMvcTest(TrainingCreationController.class)
public class TrainingCreationControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private TrainingService trainingService;
@Test
public void testCreateTraining_Success() throws Exception {
mockMvc.perform(MockMvcRequestBuilders.post("/createTraining")
.param("title", "New Training")
.param("description", "Description of the new training"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Training
created successfully"));
verify(trainingService).createTraining("New Training", "Description
of the new training");