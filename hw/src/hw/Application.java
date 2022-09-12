package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
	/*
	 * លំហាត់ទី១

ក្នុងភូមិមួយមានមនុស្ស១០នាក់។ ពួកគេមានសត្វចិញ្ចឹមតាមចំណូលចិត្តរៀងខ្លួន អ្នកខ្លះចិញ្ចឹមឆ្មា អ្នកខ្លះចិញ្ចឹមសុនក ឯអ្នកខ្លះទៀតចិញ្ចឹមសត្វច្រើនប្រភេទ។
ចូរបង្កើត Data Model និង Object ផ្សេងៗដែលបានរៀបរាប់ខាងលើ។
តាមទិន្នន័យដែលអ្នកបានបង្កើត៖
>> រាប់ចំនួនមនុស្សប្រុសនិងមនុស្សស្រី
>> តើអ្នកណាខ្លះចិញ្ចឹមសត្វលើសពី១ប្រភេទ?
>> អ្នកណាខ្លះចិញ្ចឹមឆ្មា?
>> តើប្រុសឬស្រីដែលចូលចិត្តចិញ្ចឹមឆ្មាជាងគេ?
>> តើមានអ្នកដែលអត់ចិញ្ចឹមសត្វដែរឬទេ
>> មនុស្សដែលមានអាយុតិចជាងគេឈ្មោះអ្វី?

រយៈពេលធ្វើ ៤ថ្ងៃ
	 */
	public static void main(String[] args) {
		People[] people = people();
		for(int i=0;i<people.length;i++) {
			System.out.println(people[i].toString());
		}
		
		showLine("showPeopleMaleAndFemale");
		showPeopleMaleAndFemale(people);
		showLine("");
		showLine("showPeoPleHasPetsMoreThanOne");
		showPeoPleHasPetsMoreThanOne(people);
		showLine("");
		showLine("showPeoplePetsCat");
		showPeoplePetsCat(people);
		showLine("");
		showLine("showMeleAndFemalePetCat");
		showMeleAndFemalePetCat(people);
		showLine("");
		showLine("showPeoPleNoPet");
		showPeoPleNoPet(people);
		showLine("");
		showLine("showMinAgeOfPeople");
		showMinAgeOfPeople(people);
		showLine("");
		 
		 
  		 
  		 
		

	}
	static void showLine(String name) {
		System.out.println();
		System.out.println("========================================"+name+"==================================");
	}
	
	static void showMinAgeOfPeople(People[] peoples) {
		Stream<People> s = Stream.of(peoples);
		Optional<Integer> min = s.map(a->a.getAge()).min((x,y)->x.compareTo(y));
		List<String>name = new ArrayList<String>();
        
		for(int i=0;i<peoples.length;i++) {
			
			if(peoples[i].getAge()==min.get()) {
				
				name.add((peoples[i].getName()+"("+peoples[i].getAge()+")").toString());
			}
		}
		System.out.println(name);
	}
	
	static void showPeoPleNoPet(People[] peoples) {
		List<String> name = new ArrayList<String>();
		for(int i=0 ;i<peoples.length;i++) {
			if(peoples[i].getPet().size()<=0) {
			name.add(peoples[i].getName());
			}
		}
		System.out.println(name);
	}
	
	static void showMeleAndFemalePetCat(People[] peoples) {
		List<List<String>> list = new ArrayList<>();
  		//List<String> list2 = new ArrayList<>();
  		List<String> listMale = new ArrayList<>();
  		List<String> listFemale = new ArrayList<>();
  		 
  		 int i=0,j=0;
  		for(i=0;i<peoples.length;i++) {
			 list.add(peoples[i].getPet().stream().map(a->a.getName()).collect(Collectors.toList()));
			  
			 if(peoples[i].getPet().stream().map(a->a.getName()).collect(Collectors.toList()).contains("Cat")) {
				 if(peoples[i].getGender().equals("M")) {
					 listMale.add(peoples[i].getName());
				 }
				 else {
					 listFemale.add(peoples[i].getName());
				 }
			 }
		}
  		 
  		System.out.println("People Pet Cat Male are :"+listMale.size());
  		System.out.println(listMale);
  		System.out.println("People Pet Cat Female are :"+listFemale.size());
  		System.out.println(listFemale);
	}
	
static	void showPeoplePetsCat(People[] peoples)  {
		List<List<String>> list = new ArrayList<>();
  		List<String> list2 = new ArrayList<>();
  		 
  		 int i=0;
  		for(i=0;i<peoples.length;i++) {
			 list.add(peoples[i].getPet().stream().map(a->a.getName()).collect(Collectors.toList()));
			  
			 if(peoples[i].getPet().stream().map(a->a.getName()).collect(Collectors.toList()).contains("Cat")) {
				 list2.add(peoples[i].getName());
			 }
		}
  		 
  		System.out.println(list2);
	}

	static void showPeoPleHasPetsMoreThanOne(People[] peoples) {
		List<String> name = new ArrayList<String>();
		for (int i = 0; i < peoples.length; i++) {
			if (peoples[i].getPet().size() > 1) {
				name.add(peoples[i].getName()
						+ peoples[i].getPet().stream().map(a -> a.getName()).collect(Collectors.toList()).toString());
			}
		}
		System.out.println(name);
	}

	static void showPeopleMaleAndFemale(People[] people) {

		Stream<People> s1 = Stream.of(people);
		int countM = (int) s1.filter(a -> a.getGender().contains("M")).count();
		System.out.println("Male :" + countM);
		Stream<People> s2 = Stream.of(people);
		int countF = (int) s2.filter(b -> b.getGender().contains("F")).count();
		System.out.println("Female :" + countF);
	}

	static People[] people() {
		Pet khemPet1 = new Pet("Dog", "brown", 10, 15);
		Pet khemPet2 = new Pet("Dog", "brown", 10, 15);
		ArrayList<Pet> KhemPet = new ArrayList<Pet>();
		KhemPet.add(khemPet1);
		KhemPet.add(khemPet2);
		People p1 = new People("khem", "M", 21, KhemPet);

		Pet daraPet1 = new Pet("Dog", "brown", 10, 15);
		Pet daraPet2 = new Pet("Cat", "brown", 10, 15);
		ArrayList<Pet> daraPet = new ArrayList<Pet>();
		daraPet.add(daraPet1);
		daraPet.add(daraPet2);
		People p2 = new People("Dara", "M", 19, daraPet);
		
		Pet khatPet1 = new Pet("Cow", "brown", 10, 15);
		Pet khatPet2 = new Pet("Cat", "brown", 10, 15);
		ArrayList<Pet> khatPet = new ArrayList<Pet>();
		khatPet.add(khatPet1);
		//khatPet.add(daraPet2);
		People p3 = new People("khat", "M", 17, khatPet);
		
		
		Pet kaPet1 = new Pet("Cow", "brown", 10, 15);
		Pet kaPet2 = new Pet("Cat", "brown", 10, 15);
		ArrayList<Pet> kaPet = new ArrayList<Pet>();
		kaPet.add(khatPet1);
		kaPet.add(daraPet2);
		People p4 = new People("ka", "F", 22, kaPet);
		
		
		Pet joPet1 = new Pet("Cow", "brown", 10, 15);
		Pet joPet2 = new Pet("brids", "brown", 10, 15);
		ArrayList<Pet> joPet = new ArrayList<Pet>();
//		joPet.add(khatPet1);
//		joPet.add(daraPet2);
		People p5 = new People("Jo", "F", 24, joPet);
		
		
		
		
		
		
		Pet FiPet1 = new Pet("Cow", "brown", 10, 15);
		Pet FiPet2 = new Pet("chicken", "brown", 10, 15);
		ArrayList<Pet> FiPet = new ArrayList<Pet>();
		FiPet.add(FiPet1);
		FiPet.add(FiPet2);
		People p6 = new People("Fi", "F", 22, FiPet);
		Pet RiPet1 = new Pet("Cow", "brown", 10, 15);
		Pet RiPet2 = new Pet("Cat", "brown", 10, 15);
		ArrayList<Pet> RiPet = new ArrayList<Pet>();
		RiPet.add(RiPet1);
		RiPet.add(RiPet2);
		People p7 = new People("Ri", "F", 22, RiPet);
		Pet YiPet1 = new Pet("Cow", "brown", 10, 15);
		Pet YiPet2 = new Pet("fish", "brown", 10, 15);
		ArrayList<Pet> YiPet = new ArrayList<Pet>();
		YiPet.add(YiPet1);
		YiPet.add(YiPet2);
		People p8 = new People("Yi", "F", 22, YiPet);
		Pet kuPet1 = new Pet("Cow", "brown", 10, 15);
		Pet kuPet2 = new Pet("Cat", "brown", 10, 15);
		ArrayList<Pet> kuPet = new ArrayList<Pet>();
		kuPet.add(kuPet1);
		kuPet.add(kuPet2);
		People p9 = new People("Ku", "F", 22, kuPet);
		Pet DaPet1 = new Pet("Cow", "brown", 10, 15);
		Pet DaPet2 = new Pet("bee", "brown", 10, 15);
		ArrayList<Pet> DaPet = new ArrayList<Pet>();
		DaPet.add(DaPet1);
		DaPet.add(DaPet2);
		People p10 = new People("Da", "F", 22, DaPet);

		People[] p = { p1, p2,p3,p4 ,p5,p6,p7,p8,p9,p10};

		return p;
	}

}
