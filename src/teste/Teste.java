package teste;

import util.GeradorIDs;

public class Teste 
{
	 public static void main(String[] args)
	 {
		 for(int j = 0;j<100;j++){
		 int i = GeradorIDs.gerador();
		 System.out.println(i);
		 }
	 }
}
