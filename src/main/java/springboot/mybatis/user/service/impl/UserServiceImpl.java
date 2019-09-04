package springboot.mybatis.user.service.impl;

import springboot.mybatis.user.entity.User;
import springboot.mybatis.user.dao.UserDao;
import springboot.mybatis.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hubery
 * @since 2018-08-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
