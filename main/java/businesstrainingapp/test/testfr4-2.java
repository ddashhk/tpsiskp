import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.verify;
@WebMvcTest(TrainingCommentController.class)
public class TrainingCommentControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private TrainingService trainingService;
@Test
public void testCommentTraining_Success() throws Exception {
mockMvc.perform(MockMvcRequestBuilders.post("/commentTraining")
.param("trainingId", "1")
.param("comment", "Great training!"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.content().string("Comment
added successfully"));
verify(trainingService).commentTraining(1L, "Great training!");
}
}