@objects

	body					xpath	/html/body
	container				xpath	/html/body/div[1]

	header_banner-1			xpath	/html/body/div[1]/noindex[1]
	header_banner-2			xpath	/html/body/div[1]/div[1]
	header_nav				xpath	/html/body/div[1]/header

	news-list				xpath	/html/body/div[1]/div[5]/div[1]/div[2]/div
	news-main-item			xpath	/html/body/div[1]/div[5]/div[1]/div[1]/div[2]
	news-main-item-title	xpath	/html/body/div[1]/div[5]/div[1]/div[1]/div[2]/div/h1
	news-main-item-desc		xpath	/html/body/div[1]/div[5]/div[1]/div[1]/div[2]/div/p

	news-item-1				xpath	/html/body/div[1]/div[5]/div[1]/div[2]/div/div[1]
	news-item-2				xpath	/html/body/div[1]/div[5]/div[1]/div[2]/div/div[2]
	news-item-3				xpath	/html/body/div[1]/div[5]/div[1]/div[2]/div/div[3]
	news-item-4				xpath	/html/body/div[1]/div[5]/div[1]/div[2]/div/div[4]
	news-item-5				xpath	/html/body/div[1]/div[5]/div[1]/div[2]/div/div[5]
	news-item-6				xpath	/html/body/div[1]/div[5]/div[1]/div[2]/div/div[11]

	side-bar				xpath	/html/body/div[1]/div[5]/div[2]
	side-bar_banner			xpath	/html/body/div[1]/div[5]/div[2]/noindex[1]

	show-more_button		xpath	/html/body/div[1]/div[5]/div[1]/div[2]/noindex/p/a

	slider					xpath	/html/body/div[1]/div[5]/div[1]/div[3]/div

= Header =
	header_nav:
		visible
		centered horizontally inside container
		width 970 to 980 px
		height 80 to 90 px
		below header_banner-1 15 to 25 px
		above header_banner-2 5 to 15 px

= Main content =
	container:
		visible
		centered horizontally inside body
		width 980 to 1024 px

	news-main-item:
		visible
		inside container 22 px left
		height 310 to 330 px
		width 720 to 740 px

	news-item-1:
		visible
		width 230 px
		height 240 to 260 px

	news-item-2:
		visible
		left-of news-item-3 15 to 25 px
		right-of news-item-1 15 to 25 px
		above news-item-5 15 to 25 px
		width 230 px
		height 240 to 260 px

	news-item-3:
		visible
		width 230 px
		height 240 to 260 px

	news-item-4:
		visible
		width 230 px
		height 240 to 260 px

	news-item-5:
		visible
		below news-item-2 15 to 25 px
		width 230 px
		height 240 to 260 px

	show-more_button:
		below news-item-6 25 to 35 px
		height 35 to 45 px

	side-bar:
		visible
		inside container 22 px right
		right-of news-main-item 15 to 25 px
		width 220 to 230 px

	side-bar_banner:
		visible

	slider:
		visible



