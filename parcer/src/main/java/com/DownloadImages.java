package com;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 21:53
 */
public class DownloadImages {


        //The url of the website. This is just an example
        private static final String webSiteURL = "https://www.edimdoma.ru/retsepty?page=2";

        //The path of the folder that you want to save the images to
        private static final String folderPath = "images";
//        public static void main(String[] args) {
//            try {
//                //Connect to the website and get the html
//                Document doc = Jsoup.connect(webSiteURL).get();
//                Elements links = doc.getElementsByAttributeValue("class", "card__picture");
//                //Get all elements with img tag ,
//                Elements img = links.select("img");
//                System.out.println(img.size());
//                for (Element el : img) {
//                    //for each element get the srs url
//                    String src = el.absUrl("src");
//                    System.out.println("Image Found!");
//                    System.out.println("src attribute is : "+src);
////                    getImages(src);
//                }
//            } catch (IOException ex) {
//                System.err.println("There was an error");
//                Logger.getLogger(DownloadImages.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        private static void getImages(String src) throws IOException {
//            String folder = null;
//            //Exctract the name of the image from the src attribute
//            int indexname = src.lastIndexOf("/");
//            if (indexname == src.length()) {
//                src = src.substring(1, indexname);
//            }
//            indexname = src.lastIndexOf("/");
//            String name = src.substring(indexname, src.length());
//            System.out.println(name);
//            //Open a URL Stream
//            URL url = new URL(src);
//            InputStream in = url.openStream();
//
//            OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath+ name + ".jpg"));
//
//            for (int b; (b = in.read()) != -1;) {
//                out.write(b);
//            }
//            out.close();
//            in.close();
//
//        }

}
