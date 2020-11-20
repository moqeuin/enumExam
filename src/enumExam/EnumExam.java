package enumExam;

public class EnumExam {
	
	enum Direction{EAST, SOUTH, WEST, NORTH}
	enum Number{ONE,TWO,THREE}
	
	public static void main(String[] args) {
		
		// 클래스처럼 열거형의 변수명으로 참조가능
		Direction east = Direction.EAST; // 상수하나를 클래스 취급하는 것을 알 수 있다
		Number one = Number.ONE;
		
		// 
		System.out.println(east); // EAST
		System.out.println(east.ordinal()); // 0
		//boolean ch = (east == one); //타입이 다른 enum간에는 비교가 불가능
		
		// 모든 열거형들은 enum을 상속받았기 때문에 관련 메서드를 사용할 수 있다.
		// values() 모든 열거형을 반환 
		Direction[] dArr = Direction.values();
		for (Direction d : dArr) {
			// 상수명과 상수값을 가져올 수 있다
			// name() 상수명을 문자열로 반환, ordinal()은 상수의 순서를 반환(0부터 시작)
			System.out.print(d.name()+ " " + d.ordinal() + " ");
			// EAST 0SOUTH 1WEST 2NORTH 3
		}
		// valueOf()는 문자열 상수명으로 상수를 찾는 기능을 한다
		Direction west = Direction.valueOf("WEST");
		System.out.println(west); // WEST
		System.out.println((Direction.WEST == west)); // true
		
		
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("EAST");
		Direction d3 = Direction.valueOf("WEST");
		
		
		System.out.println(d1.compareTo(d3)); // -2
		System.out.println(d1.compareTo(d2)); // 0
		
		// Direction.EAST를 명시할 수 없고 상수명으로 비교해야한다
		switch (d1) {
		case EAST:
			System.out.println("direction is EAST"); break;
		case WEST:
			System.out.println("direction is WEST"); break;
		case SOUTH:
			System.out.println("direction is SOUTH"); break;
		case NORTH:
			System.out.println("direction is NORTH"); break;
		default:
			System.out.println("invalid direction"); break;
		}
		// direction is EAST
		
	}

}
