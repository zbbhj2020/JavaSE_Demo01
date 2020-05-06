package ProjectDemo03.service;

/**
 * @Description 自定义异常类
 * @author: zbb
 * @create: 2020/5/6 20:07
 */
public class TeamException extends Exception
{
    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {
        super();
    }

    public TeamException(String message) {
        super(message);
    }
}
