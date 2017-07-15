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
	header_banner-1				xpath	//*[@id="ae5cfecc"]
	header_banner-2				xpath	/html/body/div[1]/noindex[1]/div/iframe[2]
	header_banner-3				xpath	/html/body/div[1]/div[1]/iframe
	header						xpath	/html/body/div[1]/header

	navbar						xpath	/html/body/div[1]/div[4]

	#BODY
	body 						xpath	/html/body
	body-container				xpath	/html/body/div[1]

	#NEWS CONTENT
	layout-main					xpath	/html/body/div[1]/div[5]/div[1]
	news_title					xpath	/html/body/div[1]/div[5]/div[1]/div[1]/header/h1
	news_main-image				xpath	//*[@id="material"]/span[3]/div[1]
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
	header_banner-1:
		visible

	header_banner-2:
		visible

	header_banner-3:
		visible

	header:
		visible
		centered horizontally inside body-container
		width 970 to 980 px
		height 80 to 90 px
		below header_banner-1 15 to 25 px
		below header_banner-2 15 to 25 px
		above header_banner-3 5 to 15 px

	navbar:
		visible
		centered horizontally inside body-container
		below header_banner-3 10 to 20 px
		width 975 to 985 px

= News content =

	body-container:
		visible
		centered horizontally inside body
		width 980 to 1024 px

	news_title:
		visible
		below navbar 10 to 20 px
		aligned vertically left body-container

	layout-main:
		visible
		aligned vertically left body-container

	read-more_news_img-1:
		visible

	read-more_news_img-2:
		visible

	read-more_news_img-3:
		visible

	read-more_news_img-4:
		visible

	read-more_news_img-5:
		visible

	read-more_news_img-6:
		visible

= Side bar =
	side-bar_container:
		visible
		aligned vertically right body-container