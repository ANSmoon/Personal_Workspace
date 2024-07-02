package 도서배열_관리;

public class BookManager {
	int MAX_SIZE = 100;
	int size = 0;
	
	Book[] books = new Book[MAX_SIZE];
	
	public void add(Book book) {
		if(size < 100)
			books[size++] = book;
		else
			System.out.println("그 그만 멈춰");
	}
	
	public void remove(String isbn) {

		for(int i = 0; i < size; i++) {
//			if(books[i].getIsbn().equals(isbn)) {
//				// 첫 복사 위치 = 첫 발견 위치 전까지 => 0 ~ i - 1 => 총 size = i
//				System.arraycopy(books, 0, copy, 0, i);
//				// 두번째 복사 위치 = 첫 발견 위치 후부터 끝까지 => i + 1 ~ size - 1 까지 => 총 길이 = size - i - 1
//				System.arraycopy(books, i + 1, copy, i, size - i - 1);
//			}
			// 위의 방법대로 하면 getList에서 원본을 참조하기 때문에 원본 자체를 바꿀 필요 있음.
			if(books[i].getIsbn().equals(isbn)) {
				for(int j = i; j < size-1; j++) {
					books[j] = books[j+1];
				}
				size--;
			}
		}		
	}
	
	public Book[] getList() {
		Book[] copy = new Book[size];
		for(int i = 0; i < size; i++) {
			System.arraycopy(books, 0, copy, 0, size);
		}
		return copy;
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i = 0; i < size; i++) {
			if(books[i].isbn.equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}
