import scrapy
from ..items import ZufangItem
class GanjiSpider(scrapy.Spider):
    name = "zufang"
    start_urls = ["http://sh.ganji.com/fang1/"]
    def parse(self,response):
        print(response)
        zf = ZufangItem()
        title_list = response.xpath("//div[@class='f-list-item ershoufang-list']/dl/dd[1]//a/text()").extract()
        money_list = response.xpath("//div[@class='f-list-item ershoufang-list']/dl/dd[5]/div[1]/span[1]/text()").extract()
        for i,j in zip(title_list,money_list):
            zf['title'] = i
            zf['money'] = j
            yield zf
        #     print(i,":",j)
