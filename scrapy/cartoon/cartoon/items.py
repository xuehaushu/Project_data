# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class CartoonItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    dir_name = scrapy.Field()#文件名，漫画章节名称
    link_url = scrapy.Field()#每个章节的每页链接，根据这个链接保存图片名
    img_url = scrapy.Field()#图片链接
    image_paths = scrapy.Field()#图片保存路径