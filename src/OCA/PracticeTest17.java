package OCA;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeTest17 {
	
	private static PathMatcher pathmatcher;
		
	public static void main(String args[]) {
		
		fileRelatedLogics();
	
		//providing absolute path
		Path path = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\File1.txt");
		System.out.println(path);
		
		//specifying the relative path
		Path path1 = Paths.get("C:\\", "Personal\\Eclipse-workspace\\..\\Eclipse-workspace\\File-Test\\File2.txt");
		System.out.println(path1);
		
		Path path2 = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\", "dir/subreddit");
		System.out.println(path2);
		
		//normalize removes the ..\\ or any other intermediate unnecessary traversals
		System.out.println(path1.normalize());
		
		//Files exists and LinkOption. LinkOption is to influence how the Files.exists()
		//determines if the file exists or not
		
		Path path6 = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\dir");
		try {
			LinkOption linkOptns = LinkOption.valueOf("NOFOLLOW_LINKS");
			linkOptns = LinkOption.NOFOLLOW_LINKS;
			//both above lines are same
			boolean pathIfExists = Files.exists(path, linkOptns);
			
			//creates the directories recursively. Even if the parent provided not available
			//then it will be created automatically
			Path newDir = Files.createDirectories(path2);
			
			//copy files
			Path path3 = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\File2.txt");
			Path path4 = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\dir\\File2.txt");
			
			Files.move(path4, path3, StandardCopyOption.REPLACE_EXISTING);
			
			Files.copy(path3, path4, StandardCopyOption.REPLACE_EXISTING);
			
			
			path6 = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\dir");
			//Cannot delete a directory if its not empty
			//Files.delete(path6);
			
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			/* FileVisitor is used to search any file inside a recursise sub directories of
			 * files
			 * FileVisitor has 4 methods namely preVisitDirectory, postVisitDirectory,
			 * visitFileFailed, visitFile
			 * Each method returns TERMINATE, CONTINUE, SKIP_SIBLINGS, SKIP_SUBTREE - these are enums.
			 * Here we need to extend SimpleFileVisitor<Path>
			 * 
			*/
			SimpleFileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
				
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrbs) throws IOException {
					String nameOfFile = file.toAbsolutePath().toString();
					
					if(nameOfFile.endsWith("2.txt")) {
						System.out.println("Found file");
						return FileVisitResult.TERMINATE;
					}
					
					return FileVisitResult.CONTINUE;
				}
			};
			
			Files.walkFileTree(Paths.get("src"), visitor);
			
			pathmatcher = FileSystems.getDefault().getPathMatcher("glob:**");
			if(pathmatcher.matches(Paths.get("src"))) {
				System.out.println(Paths.get("src"));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		try {
			BufferedWriter writer = Files.newBufferedWriter(Paths
					.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\File1.txt"), new OpenOption[]
							{StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE});
			writer.write("two wrote");
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Paths. If file already exists and you try to replace. We get exception.
		
		/*
		Path p1 = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\File1.txt");
		Path p2 = Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\File4.txt");
		try {
			System.out.println(Files.getAttribute(p1, "size"));
			Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
		//PathMatcher instance
		
		//OpenOption[] options = new OpenOption[]{StandardOpenOption.WRITE,StandardOpenOption.READ};//Throws READ not allowed exception
		OpenOption[] options = new OpenOption[]{StandardOpenOption.APPEND,StandardOpenOption.WRITE};//
		//Files write
		try {
			Files.write(Paths.get("C:\\Personal\\Eclipse-workspace\\Files-Test\\File1.txt"), "abc".getBytes(), options);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path ne1 = Paths.get("./../file1");
		Path ne2 = Paths.get("file2");
		System.out.println(ne1.resolve(ne2));
		System.out.println(ne1.relativize(ne2));

		
	}
	
	public static void someOtherConcepts() {
		Map<String, String> countries = new HashMap<String, String>();
		countries.put("India", "Delhi");
		countries.merge("India", "Chennai", (i1,i2) -> i1+i2);
		countries.merge("Srilanka", "Colombo", String::concat);
		System.out.println(countries);
	}
	
	public static void workWithNos() {
		
		int base = 29;
		
		calculate(base, x-> base*x);

		List<Integer> hellp = new ArrayList();
		hellp.add(1);
		hellp.add(3);
		hellp.add(5);
		
		System.out.print(hellp.stream().filter(i->i%2==0).filter(i->i%2==0)
				.filter(i->i%2==0).collect(Collectors.toList()));

		double amt = 12.34;
		NumberFormat format = new DecimalFormat("\u0024#.00");
		System.out.println(format.format(amt));
		
		Format form = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(form.format(amt));
		
		//nos to bytes etc
		int number1 = 0b111;
        int number2 = 0_1735;
        int number3 = 0x111;
        System.out.println(number1);//7
        System.out.println(number2);//73
        System.out.println(number3);//273
        System.out.println(number1 + number2 + number3);
	}

	private static void calculate(int base, Function<Integer, Integer> func) {
		System.out.println("base:" + base);
		System.out.println("func:" + func.apply(base));
	}
	
	//AtomicInteger is used for safely using the variable in a thread safe environment
	//without the need to synchronized the code
	
	
	private static void fileRelatedLogics() {
		AtomicInteger flag = new AtomicInteger();
		int oldValue = flag.get();
		int newValue = flag.addAndGet(1);
		int newValue1 = flag.getAndUpdate(i->i+1);
		System.out.println(newValue);
		System.out.println(newValue1);
	}
}