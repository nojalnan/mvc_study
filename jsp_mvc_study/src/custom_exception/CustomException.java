package custom_exception;

import java.sql.SQLException;

public class CustomException extends SQLException {

	public CustomException(String msg){
		super("알 수 없는 오류가 발생하였습니다.");
	}
}
