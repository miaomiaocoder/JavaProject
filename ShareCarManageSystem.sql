CREATE DATABASE [ShareCarManageSystem]
GO
USE [ShareCarManageSystem]
GO
/****** Object:  Table [dbo].[t_admin]    Script Date: 2019/4/14 5:19:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_admin](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_car]    Script Date: 2019/4/14 5:19:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_car](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Color] [varchar](50) NOT NULL,
	[Type] [varchar](50) NOT NULL,
	[Price] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_fixCar]    Script Date: 2019/4/14 5:19:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_fixCar](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FixDate] [varchar](50) NULL,
	[Question] [varchar](50) NULL,
	[CarId] [int] NULL,
	[Price] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_rentCar]    Script Date: 2019/4/14 5:19:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_rentCar](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[RentDate] [varchar](50) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[CarID] [varchar](50) NOT NULL,
	[Price] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[t_repayCar]    Script Date: 2019/4/14 5:19:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_repayCar](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[RepayDate] [varchar](50) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[CarID] [int] NOT NULL,
	[Status] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[t_admin] ON 
GO
INSERT [dbo].[t_admin] ([ID], [UserName], [Password]) VALUES (1, N'admin', N'admin')
GO
SET IDENTITY_INSERT [dbo].[t_admin] OFF
GO
SET IDENTITY_INSERT [dbo].[t_car] ON 
GO
INSERT [dbo].[t_car] ([ID], [Name], [Color], [Type], [Price]) VALUES (1, N'单车', N'白色', N'自行车', 1)
GO
INSERT [dbo].[t_car] ([ID], [Name], [Color], [Type], [Price]) VALUES (2, N'单车', N'红色', N'自行车', 1)
GO
INSERT [dbo].[t_car] ([ID], [Name], [Color], [Type], [Price]) VALUES (3, N'单车', N'蓝色', N'自行车', 1)
GO
INSERT [dbo].[t_car] ([ID], [Name], [Color], [Type], [Price]) VALUES (4, N'单车', N'黄色', N'自行车', 1)
GO
INSERT [dbo].[t_car] ([ID], [Name], [Color], [Type], [Price]) VALUES (5, N'单车', N'绿色', N'自行车', 1)
GO
SET IDENTITY_INSERT [dbo].[t_car] OFF
GO
SET IDENTITY_INSERT [dbo].[t_fixCar] ON 
GO
INSERT [dbo].[t_fixCar] ([ID], [FixDate], [Question], [CarId], [Price]) VALUES (1, N'2014-04-14', N'轮胎漏气', 4, 2)
GO
INSERT [dbo].[t_fixCar] ([ID], [FixDate], [Question], [CarId], [Price]) VALUES (2, N'2014-04-14', N'轮胎漏气', 5, 2)
GO
SET IDENTITY_INSERT [dbo].[t_fixCar] OFF
GO
SET IDENTITY_INSERT [dbo].[t_rentCar] ON 
GO
INSERT [dbo].[t_rentCar] ([ID], [RentDate], [Name], [CarID], [Price]) VALUES (1, N'2019-04-13', N'张三', N'1', 10)
GO
INSERT [dbo].[t_rentCar] ([ID], [RentDate], [Name], [CarID], [Price]) VALUES (2, N'2019-04-13', N'李四', N'2', 10)
GO
INSERT [dbo].[t_rentCar] ([ID], [RentDate], [Name], [CarID], [Price]) VALUES (3, N'2019-04-13', N'王菲', N'3', 10)
GO
SET IDENTITY_INSERT [dbo].[t_rentCar] OFF
GO
SET IDENTITY_INSERT [dbo].[t_repayCar] ON 
GO
INSERT [dbo].[t_repayCar] ([ID], [RepayDate], [Name], [CarID], [Status]) VALUES (1, N'2019-04-13', N'张三', 1, N'已还')
GO
INSERT [dbo].[t_repayCar] ([ID], [RepayDate], [Name], [CarID], [Status]) VALUES (2, N'2019-04-13', N'李四', 2, N'已还')
GO
INSERT [dbo].[t_repayCar] ([ID], [RepayDate], [Name], [CarID], [Status]) VALUES (3, N'2019-04-13', N'王菲', 3, N'已还')
GO
SET IDENTITY_INSERT [dbo].[t_repayCar] OFF
GO
