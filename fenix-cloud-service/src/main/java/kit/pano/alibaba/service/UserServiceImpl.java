package kit.pano.alibaba.service;

import kit.pano.alibaba.api.UserService;
import kit.pano.alibaba.api.model.UserModel;
import kit.pano.alibaba.dao.dataobject.UserDO;
import kit.pano.alibaba.dao.mapper.UserMapper;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
public class UserServiceImpl implements UserService {

    private static final BeanCopier copier = BeanCopier.create(UserModel.class, UserDO.class, false);

    @Resource
    private UserMapper userMapper;

    @Override
    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        return userDO != null ? userDO.getName() : null;
    }

    @Override
    public UserModel addUser(UserModel user) {
        UserDO userDO = new UserDO();
        copier.copy(user, userDO, null);

        Long id = userMapper.insert(userDO);
        user.setId(id);
        return user;
    }
}
