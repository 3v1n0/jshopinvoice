package media;

import item.ItemFeatureValue;

public class Video extends Media {

		protected Video() {};
		protected Video(String house, Integer year, String director, String actors, String title,
						Integer length, String genre, String lang, String subs, String fmt, String desc, Float price) {
			super(house, year, title, length, genre, lang, desc, price);
			addFeature("Director", new ItemFeatureValue(director));
			addFeature("Actors", new ItemFeatureValue(actors));
			addFeature("Subtitles", new ItemFeatureValue(subs));
			addFeature("Format", new ItemFeatureValue(fmt));
		}
		
		protected String createType() {return "Video Media";}
		
		public String getDirector() {return getFeature("Director").getStringValue();}
		public String getActors() {return getFeature("Actors").getStringValue();}
		public String getSubtitles() {return getFeature("Subtitles").getStringValue();}
		public String getFormat() {return getFeature("Format").getStringValue();}
		
		Media createMedia() {return new Video();}
		final Media createMediaType() {return new Video();}
}
