#2 banners in header
#news caption
#author - clickable
#comments in news header = actual comments
#tags clickable
#news main image
#banner after news content
#look more
#sidebanners, 2

@objects
	#HEADER
	header_banner-1				xpath	/html/body/div[1]/noindex[1]/div/iframe[1]
	header_banner-2				xpath	/html/body/div[1]/noindex[1]/div/iframe[2]
	header_banner-3				xpath	/html/body/div[1]/div[1]/iframe
	header_main-nav-bar			xpath	/html/body/div[1]/header

	#BODY
	body 						xpath	/html/body
	body-container				xpath	/html/body/div[1]

	#NEWS CONTENT
	news_title					xpath	/html/body/div[1]/div[5]/div[1]/div[1]/header/h1
	news_main-image				xpath	/html/body/div[1]/div[5]/div[1]/div[1]/span[3]/div[1]/div/img
	news_content				xpath	/html/body/div[1]/div[5]/div[1]/div[1]/span[3]
	news_paragraph				xpath	/html/body/div[1]/div[5]/div[1]/div[1]/span[3]/div[1]/p[2]
	news_banner-1				xpath	/html/body/div[1]/div[5]/div[1]/noindex[1]/iframe
	news_banner-2				xpath	/html/body/div[1]/div[5]/div[1]/noindex[2]/iframe
	news_commentary-add-form	xpath	/html/body/div[1]/div[5]/div[1]/div[3]/noindex/form

	#SIDE BAR
	side-bar_container			xpath	/html/body/div[1]/div[5]/div[2]
	side-bar_banner-1			xpath	/html/body/div[1]/div[5]/div[2]/noindex[1]/iframe
	side-bar_banner-2			xpath	/html/body/div[1]/div[5]/div[2]/noindex[2]/iframe
	side-bar_headings			xpath	/html/body/div[1]/div[5]/div[2]/div[2]

	#READ MORE
	read-more_news-1			xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[1]
	read-more_news-2			xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[2]
	read-more_news-3			xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[3]
	read-more_news-4			xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[4]
	read-more_news-5			xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[5]
	read-more_news-6			xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[6]

	read-more_news_img-1		xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[1]/div/a/div[1]/img
	read-more_news_img-2		xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[2]/div/a/div[1]/img
	read-more_news_img-3		xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[3]/div/a/div[1]/img
	read-more_news_img-4		xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[4]/div/a/div[1]/img
	read-more_news_img-5		xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[5]/div/a/div[1]/img
	read-more_news_img-6		xpath	/html/body/div[1]/div[5]/div[1]/div[4]/div/div/div[2]/div[6]/div/a/div[1]/img


= Header =
	


= News content =
	


= Side bar =
	


