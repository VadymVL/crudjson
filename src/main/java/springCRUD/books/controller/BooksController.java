package springCRUD.books.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import springCRUD.books.model.Book;
import springCRUD.books.service.BooksService;

@Controller
@RequestMapping("/book")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@RequestMapping(value = {"/", "/list"})
	public String listBooks(Map<String, Object> map) {
		map.put("book", new Book());
		map.put("listBooks", booksService.listBooks());
		return "/book/booksList";
	}
	
	@RequestMapping(value = {"/get/{bookId}", "/list/get/{bookId}"})
	public String getBook(@PathVariable long bookId, Map<String, Object> map) {
		map.put("book", booksService.getBook(bookId));
		return "/book/bookForm";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book, BindingResult result) {
		booksService.saveBook(book);
		return "redirect:list"; //there is no slash after the redirect. so we are in parent book/ path
	}
	
	@RequestMapping("delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") long id) {
		booksService.deleteBook(id);
		return "redirect:/book/list";//there IS a slash
	}
	
	@RequestMapping("/json/book/{id}")
	public @ResponseBody  
	 Book getJsonBook(@PathVariable long id) {
		return booksService.getBook(id);
	}
	
	@RequestMapping(value = "/json/list.json", headers="Accept=*/*", method=RequestMethod.GET)
	public @ResponseBody  
	 List<Book> getJsonBookList() {
		return booksService.listBooks();
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "/book/upload";//"You can upload a file by posting to this same URL.";
    }

/*    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file_name") String file_name,
            @RequestParam("file") MultipartFile file){
    	  if (!file.isEmpty()) {
            try {
            	String fileName=file.getOriginalFilename();
                byte[] bytes = file.getBytes();
       //         File newFile = new File(filePath);
         //       newFile.mkdirs();
           //     if(!newFile.exists())newFile.createNewFile();
            //    file.transferTo(newFile);
                //File newFile = new File("/images/" + fileName);
               // newFile.mkdirs();
                //if(!newFile.exists()) newFile.createNewFile();
                // saving the file
                //File saveFile=new File(directory.getAbsolutePath()+System.getProperty("file.separator")+fileName);
                //File saveFile = new File(file_name);
                BufferedOutputStream stream =
                       new BufferedOutputStream(new FileOutputStream(new File("images/" + fileName)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + file_name + "!";
            } catch (Exception e) {
                return "You failed to upload " + file_name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file_name + " because the file was empty.";
        }
    		System.out.println("File Description:"+file_name);
	String fileName = null;
	if (!file.isEmpty()) {
        try {
            fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            File newFile = new File("images/" + fileName);
            newFile.mkdir();
            if(!newFile.exists()) newFile.createNewFile();
            BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(newFile));
            buffStream.write(bytes);
            buffStream.close();
            return "You have successfully uploadedfile " + fileName;
        } catch (Exception e) {
            return "You failed to uploadfile " + fileName + ": " + e.getMessage();
        }
    } else {
        return "Unable to uploadfile. File is empty.";
    }	
    		
    }*/
	
	 @RequestMapping(value="/upload", method=RequestMethod.POST )
	    public @ResponseBody String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("file_name") String file_name ){
	    	System.out.println("File Description:"+file_name);
	    	String fileName = null;
	    	if (!file.isEmpty()) {
	            try {
	                fileName = file.getOriginalFilename();
	                //byte[] bytes = file.getBytes();
	                File rootDir = new File("/home/mif/Downloads/Stuff");
	                File uploadedFile = new File(rootDir, fileName);
	                file.transferTo(uploadedFile);
	               // File newFile = new File("/home/images/" + fileName);
	               // if(!newFile.exists()) {
	               // 	newFile.mkdir();
	              //  	newFile.createNewFile();
	             //   	newFile.setWritable(true);
	              //  }
	              //  BufferedOutputStream buffStream = 
	             //           new BufferedOutputStream(new FileOutputStream(newFile));
	            //    buffStream.write(bytes);
	            //    buffStream.close();
	                return "You have successfully  uploaded file: " + fileName + "<br> And you can also download it back, following this link - " + uploadedFile.getCanonicalFile() + " <br> " + uploadedFile.getAbsoluteFile();
	            } catch (Exception e) {
	                return "You failed to " + fileName + ": " + e.getMessage();
	        //    } finally {
	         //   	return "are you sure?"; 
	            }
	        } else {
	            return "Unable to . File is empty.";
	        }
	    }

}
