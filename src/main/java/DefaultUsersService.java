import dto.UsersDto;
import repository.Users;
import service.UsersService;

import java.util.List;

import static java.util.Objects.isNull;

public class DefaultUsersService implements UsersService {

    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public UsersDto findByLogin(String login) {
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return null;
    }

    private void validationUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }
}
