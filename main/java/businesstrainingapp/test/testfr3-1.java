import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
@WebMvcTest(TrainingHistoryController.class)
public class TrainingHistoryControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
12
private TrainingService trainingService;
@Test
public void testGetTrainingHistory_Success() throws Exception {
List<Training> trainingHistory = new ArrayList<>();
when(trainingService.getTrainingHistory(1L)).thenReturn(trainingHistory);
mockMvc.perform(MockMvcRequestBuilders.get("/trainingHistory")
.param("userId", "1"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
}
}