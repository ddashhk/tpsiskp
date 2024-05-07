import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
20
@Autowired
private MockMvc mockMvc;
@MockBean
private ReviewService reviewService;
@Test
public void testGetTrainingReviews_Success() throws Exception {
Review review1 = new Review("Great training!");
Review review2 = new Review("Very informative.");
List<Review> reviews = Arrays.asList(review1, review2);
when(reviewService.getTrainingReviews(1L)).thenReturn(reviews);
mockMvc.perform(MockMvcRequestBuilders.get("/reviews/1"))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(MockMvcResultMatchers.jsonPath("$[0].comment").val
ue("Great training!"))
.andExpect(MockMvcResultMatchers.jsonPath("$[1].comment").val
ue("Very informative."));
}
}