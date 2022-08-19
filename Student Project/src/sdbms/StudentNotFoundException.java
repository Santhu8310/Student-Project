package sdbms;

class StudentNotFoundException extends RuntimeException {
	private String message;
	StudentNotFoundException(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return message;
	}

}
