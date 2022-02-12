package model;

	public class app {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			DAO macas = new DAO();
//			System.out.println(maca.listaDeCarro());
//			
		    Carro carro = new Carro("text",1999);
			macas.novoCarro(carro);
			System.out.println(macas.listaDeCarro());
//			User laranja1 = new User("Will", "Japão", "melao@rd.com.br");
//			maca.insert(laranja1);
//			System.out.println(maca.selectAll());
//			
//			maca.delete(2);
//			System.out.println(maca.selectAll());
//			
//			User laranja2 = new User("Muryllo", "Malásia", "uva@rd.com.br");
//			maca.insert(laranja2);
//			System.out.println(maca.selectAll());
//			
//			maca.delete(2);
//			System.out.println(maca.selectAll());
////			
		    carro.setAno(999);
			macas.updateCarro(carro);
		    System.out.println(macas.listaDeCarro());
////			
//			User novo = maca.selectById(3);
//			System.out.println(novo);
//			
//			User novo1 = maca.selectById(10);
//			System.out.println(novo1);
		}

		}
