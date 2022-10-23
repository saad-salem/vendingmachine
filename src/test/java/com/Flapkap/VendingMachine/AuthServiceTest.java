//package com.Flapkap.VendingMachine;
//
//import com.Flapkap.VendingMachine.user.dto.request.StoreUserRequest;
//import com.Flapkap.VendingMachine.user.service.AuthService;
//import com.Flapkap.VendingMachine.user.service.UserService;
//import com.Flapkap.VendingMachine.user.service.impl.AuthServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//
//import static org.assertj.core.api.BDDAssertions.then;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//
//@ExtendWith(MockitoExtension.class)
//public class AuthServiceTest {
//    @Mock
//    private AuthService authService;
//    @InjectMocks
//    private AuthServiceImpl authServiceImpl;
//    @Mock
//    private UserService userService;
//
//
//    @Test
//    void registerTest() throws Exception {
//        // given
//        StoreUserRequest request=new StoreUserRequest();
//        request.setUserName("sa3d01");
//        request.setPassword("123456");
//        request.setRole("BUYER");
//        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 70, "john", 3500);
//        ChallengeAttempt expectedResponse = new ChallengeAttempt(attemptId, user.getId(), 50, 70, 3500, true);
//
//        given(authService
//                .register(request).;
//        // when
//        MockHttpServletResponse response = mvc.perform(
//                        post("/attempts").contentType(MediaType.APPLICATION_JSON)
//                                .content(jsonRequestAttempt.write(attemptDTO).getJson()))
//                .andReturn().getResponse();
//        // then
//        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        then(response.getContentAsString()).isEqualTo(
//                jsonResultAttempt.write(
//                        expectedResponse
//                ).getJson());
//    }
//}
