import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.verify;
@WebMvcTest(TrainingRatingController.class)
public class TrainingRatingControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private TrainingService trainingService;
@Test
public void testRateTraining_Success() throws Exception {
mockMvc.perform(MockMvcRequestBuilders.post("/rateTraining")
.param("trainingId", "1")
.param("rating", "5"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Training
rated successfully"));
verify(trainingService).rateTraining(1L, 5);
}
}