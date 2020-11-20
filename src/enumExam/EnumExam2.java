package enumExam;


public class EnumExam2 {
	
	public static void main(String[] args) {
		
		// ordinal()를 상수값을 사용하는 것이 아닌 임의값을 지정해서 상수를 정할 수 있다
		
		for (Direction d : Direction.values()) {
			System.out.printf("%s=%d%n",d.name(), d.getValue());
		}
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.Of(1);
		
		System.out.print(d1.name() + " " + d1.getValue()); //EAST 1
		System.out.println();
		System.out.println(d1);  // EAST>
		System.out.println(d1.rotate(3)); // NORTH^
		System.out.println(d2.rotate(1)); // WESTV 
	}

}

enum Direction{
	// 지정할 값을 넣기 위해서 생성자가 필요
	EAST(1, ">"),WEST(2,"V"),SOUTH(3,"<"),NORTH(4,"^");
	
	private static final Direction[] DIR_ARR = Direction.values();
	
	// 상수를 저장하기 때문에 final지정
	private final int value;
	private final String symbol;
	// private이기 떄문에 열거형의 생성자는 사용할 수 없다
	private Direction(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	public int getValue() {return value;}
	public String getSymbol() {return symbol;}
	
	// 상수값을 가져옴, 범위에 맞지 않으면 예외처리 
	public static Direction Of(int dir) {
		if(dir < 1 || dir > 5) 
			throw new IllegalArgumentException("invalid value : " + dir);
			return DIR_ARR[dir - 1];		
	}
	
	// 입력한 값만큼 시계방향으로 90도씩 회전
	public Direction rotate(int num) {
		//
		num = num % 4;
		
		if( num < 0) num +=4;
		// 이동 하기전에 0부터 가져와야하기에 -1을 하고 한바퀴도는걸 고려해서 4로 나눈다.
		return DIR_ARR[(value-1+num) % 4];
	}
	
	public String toString() {
		return name() + getSymbol();
	}
}// enum Direction