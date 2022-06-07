
public class Teste {
	public static void main(String[] args) {
		try {
			Class classe = Class.forName("java.lang.String");
			String nome = (String) classe.newInstance();
			System.out.println("classe: "+nome.getClass());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
