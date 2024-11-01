package services;

import ofofo.data.services.DiaryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiaryServiceImplTest {
    private DiaryServiceImpl diaryService;
    @BeforeEach
    void setUp() {
        diaryService = new DiaryServiceImpl();
    }

    @Test
    public void registerNewUser_userCountIsOneTest() {
        assertEquals(0, diaryService.count());
        diaryService.register("username", "password");
        assertEquals(1, diaryService.count());
    }

    @Test
    public void registerSameUserTwice_registerWillThrowExceptionTest() {
        assertEquals(0, diaryService.count());
        diaryService.register("username", "password");
        assertEquals(1, diaryService.count());
        assertThrows(IllegalArgumentException.class, () -> diaryService.register("username", "password"));
        assertEquals(1, diaryService.count());
    }

    @Test
    public void loginUser_userLoginCountIsOneTest() {
        assertEquals(0, diaryService.userLoginCount());
        assertEquals(0, diaryService.count());
        diaryService.register("username", "password");
        diaryService.login("username", "password");
        assertEquals(1
                , diaryService.userLoginCount());
        assertEquals(1, diaryService.count());
    }

    @Test
    public void loginUserWithWrongPassword_registerWillThrowExceptionTest() {
        assertEquals(0, diaryService.count());
        diaryService.register("username", "password");
        assertEquals(1, diaryService.count());
        assertEquals(0, diaryService.userLoginCount());
        assertThrows(IllegalArgumentException.class, () -> diaryService.login("username1", "password"));
        assertEquals(0, diaryService.userLoginCount());
    }

}
