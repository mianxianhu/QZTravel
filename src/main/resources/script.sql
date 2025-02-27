USE [Travel]
GO
/****** Object:  User [QZTW]    Script Date: 2025/1/4 17:56:57 ******/
CREATE USER [QZTW] FOR LOGIN [QZTW] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[comments]    Script Date: 2025/1/4 17:56:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comments](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](255) NOT NULL,
	[comment] [varchar](1024) NULL,
	[date] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[foods]    Script Date: 2025/1/4 17:56:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[foods](
	[name] [varchar](255) NOT NULL,
	[description] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[scenic_spots]    Script Date: 2025/1/4 17:56:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[scenic_spots](
	[name] [varchar](50) NULL,
	[description] [varchar](1024) NULL,
	[address] [nvarchar](128) NULL,
	[openTime] [varchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ticket_orders]    Script Date: 2025/1/4 17:56:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ticket_orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [varchar](20) NULL,
	[scenic_spot_id] [varchar](20) NULL,
	[order_time] [varchar](20) NULL,
	[quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 2025/1/4 17:56:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[comments] ON 

INSERT [dbo].[comments] ([id], [username], [comment], [date]) VALUES (4, N'admin', N'Quanzhou is fun and delicious!', N'2025-1-3')
INSERT [dbo].[comments] ([id], [username], [comment], [date]) VALUES (5, N'admin', N'Welcome to Quanzhou', N'2025-1-3')
SET IDENTITY_INSERT [dbo].[comments] OFF
GO
INSERT [dbo].[foods] ([name], [description]) VALUES (N'gypsum', N'Quanzhou''s unique famous snack. Eating it in hot weather can cool down and reduce internal heat. It has a history of hundreds of years in Quanzhou and is still very popular. Shihua paste is made from shihua grass')
INSERT [dbo].[foods] ([name], [description]) VALUES (N'Mung bean cake', N'Quanzhou characteristic traditional pastry. Famous for its thin layer of puff pastry')
INSERT [dbo].[foods] ([name], [description]) VALUES (N'Beef soup', N'A very famous snack in Quanzhou')
INSERT [dbo].[foods] ([name], [description]) VALUES (N'Fish balls (water balls)', N'The traditional famous spot in Quanzhou is the most representative of the fish balls in Shenhu Town')
INSERT [dbo].[foods] ([name], [description]) VALUES (N'Frozen bamboo shoots', N'Clay bamboo shoots')
INSERT [dbo].[foods] ([name], [description]) VALUES (N'batter', N'Quanzhou local specialty snacks are mainly made of ultra-fine noodles handmade in rural Quanzhou and delicious seafood such as pig tube bones')
INSERT [dbo].[foods] ([name], [description]) VALUES (N'oyster fry', N'Quanzhou-style snack sea oyster fried has a history of more than 1')
GO
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Qingyuan Mountain', N'Qingyuan Mountain, a Southeast resort, Qixiu Qingyuan, is one of the eighteen scenic spots in Quanzhou, with mountains and water, strong religious culture, continuous mountains, towering and beautiful, quiet and simple stone statues, clocked in Laojun statues, is the largest and longest existing Taoist stone statues in China, very shocking!', N'Quanshan Road, Fengze District, Quanzhou City', N'6:00-22:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Quanzhou Kaiyuan Temple', N'Kaiyuan Temple is the largest Buddhist temple in Fujian Province. It was built in the Tang Dynasty and has a long history. It preserves many ancient Buddhist cultural relics and works of art. It is full of cultural relics and is known as a treasure house of cultural heritage. The temple architecture is magnificent and spectacular, and you can understand the essence of Buddhist culture.', N'176 West Street, Licheng District, Quanzhou City', N'6:00-23:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Guanyue Temple', N'The Guanyue Temple in Quanzhou, which is dedicated to Guan Yu and Yue Fei, is a famous ancient site for worshiping the sages of culture and martial arts. The incense is strong, and it is also the most efficacious temple in the eyes of the locals. The temple is large in scale, preserves many ancient relics, and the temple architecture is spectacular and simple. Many pilgrims are famous.', N'No. 188, Tumen Street, Licheng District, Quanzhou City.', N'6:00-21:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Yongning ancient town', N'The ancient town of Yongning is the largest ancient acropolis in Quanzhou, with a history of more than 600 years. It retains many temples and ancient dwellings. The original ancient city is not commercialized and is simple and natural. The small town is full of years, allowing you to feel the charm of the old street.', N'G228, Shishi City, Quanzhou City', N'6:00-21:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Quanzhou Qingjing Temple', N'Quanzhou Qingjing Temple, also known as Qilin Temple, is the oldest and unique Islamic-style ancient halal temple in our country. The architectural lines of Qingjing Temple are very beautiful, and the form of the gate tower is a typical West Asian mosque style. There are also ancient Arabic stone carvings in the temple to appreciate the beauty of religious architecture.', N'No. 108-110, Tumen Street, Licheng District, Quanzhou City', N'9:00-19:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Luoyang Bridge', N'The Luoyang Bridge in Quanzhou has stood for thousands of years and is the earliest existing cross-sea beam stone bridge in China. It is known as the first bridge in China. The stone bridge is ancient and solemn. The Luoyang River rolls eastward under the bridge. Walking on the stone bridge, you can appreciate the wisdom of the ancients and feel a profound sense of history.', N'Intersection of Qiaonan Street and Cai Xiang Road, Luojiang District, Quanzhou City.', N'6:00-21:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Anxi Qingshuiyan', N'Anxi Qingshui Rock is a well-known Buddhist holy place in the local area. It has beautiful mountains and rivers and strange scenery. It is known as the Penglai Wonderland. Qingshui Rock is dedicated to the founder of Qingshui, with towering and magnificent pavilions and incense. Here, pray for blessings and burn incense to enjoy inner peace.', N'No. 1, Qingshuiyan, Pengxi Village, Penglai Town, Anxi County, Quanzhou City', N'6:00-22:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Quanzhou West Street', N'Quanzhou West Street is a thousand-year-old street, and it is also a famous pedestrian street in Quanzhou. It preserves many cultural relics and still retains the appearance of Quanzhou''s old city. There are many arcade buildings with Fujian characteristics on the street, and the ancient buildings are scattered. Walk on the bustling streets and feel the fireworks of the ancient streets.', N'Quanzhou Licheng District', N'5:00-24:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Jinjiang wulin traditional village', N'The traditional village of Wulin in Jinjiang is a century-old ancient village in Quanzhou, with the characteristics of southern Fujian. It has the reputation of Overseas Chinese Architecture Museum. The gorgeous and red ancient houses in the ancient village are scattered, and you can stroll along the long stone road to feel the vicissitudes of the ancient village.', N'Dongxi San Road, Jinjiang City, Quanzhou City', N'6:00-22:00')
INSERT [dbo].[scenic_spots] ([name], [description], [address], [openTime]) VALUES (N'Chongwu ancient city', N'Chongwu Ancient City is the most complete T-shaped stone city in China, a stone city built to resist Japanese pirates. The houses in the ancient city are made of whole square stones, and there are all stone streets. Through the vicissitudes of life, they have retained their original appearance, peaceful and simple.', N'Quanzhou Huian County Southeast Seaside', N'6:00-22:00')
GO
SET IDENTITY_INSERT [dbo].[ticket_orders] ON 

INSERT [dbo].[ticket_orders] ([order_id], [user_id], [scenic_spot_id], [order_time], [quantity]) VALUES (2, N'2', N'3', N'2025-1-1', 3)
INSERT [dbo].[ticket_orders] ([order_id], [user_id], [scenic_spot_id], [order_time], [quantity]) VALUES (3, N'1', N'1', N'2025-1-1', 1)
SET IDENTITY_INSERT [dbo].[ticket_orders] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [username], [password]) VALUES (1, N'user', N'123')
INSERT [dbo].[users] ([id], [username], [password]) VALUES (18, N'admin', N'123456')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
