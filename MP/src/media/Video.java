package media;

public class Video extends Media {
		
		private String director;
		private String actors;
		private String subtitles;
		private String format;
		//private boolean color; //TODO??? no

		protected Video() {};
		protected Video(String house, String dir, String act, String title, Integer len,
						String genre, String lang, String sub, String fmt, String desc, Float price) {
			super(house, title, len, genre, lang, desc, price);
			director = dir;
			actors = act;
			subtitles = sub;
			format = fmt;
		}
		
		public String getInfo(){
			String s;
			s = "Title:\t\t"+getTitle()+
				"\nDirector:\t\t"+director+
				"\nMajor:\t\t"+getBrand()+
				"\nDuration:\t"+getDuration()+
				"\nLanguage:\t"+getLanguage()+
				"\nActors:\t\t"+actors+
				"\nFormat:\t\t"+format+
				"\nSubtitles:\t"+subtitles+
				"\nType:\t\t"+getMediaType()+
				"\nSupport:\t"+getMedia();
			return s;
		}
		
		protected String createType() {return "Video Media";}
		
		public String getDirector() {return director;}
		public String getActors() {return actors;}
		public String getSubtitles() {return subtitles;}
		public String getFormat() {return format;}
		public String getName() {return getTitle()+" by "+getDirector();}
		
		Media createMedia() {return new Video();}
		final Media createMediaType() {return new Video();}
}
