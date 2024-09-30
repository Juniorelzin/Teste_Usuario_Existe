import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.User;
import com.example.UserRepository;
import com.example.UserService;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
     
        userRepository = Mockito.mock(UserRepository.class);
  
        userService = new UserService(userRepository);
    }

    @Test
    public void testAddUser_UserDoesNotExist() {
  
        User newUser = new User("ultron", "ultron@gmail.com");
        when(userRepository.userExists(newUser.getEmail())).thenReturn(false);

    
        String result = userService.addUser(newUser);

   
        verify(userRepository).addUser(newUser);

        assertEquals("User added successfully.", result);

    }

    @Test
    public void testAddUser_UserExists() {
   
        User existingUser = new User("ultron", "ultron@gmail.com");
        when(userRepository.userExists(existingUser.getEmail())).thenReturn(true);

        String result = userService.addUser(existingUser);

       
        verify(userRepository, never()).addUser(existingUser);
      
        assertEquals("User already exists.", result);
    }
}


