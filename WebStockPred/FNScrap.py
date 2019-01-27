#BeautifulSoup and Requests are needed
import urllib2
import BeautifulSoup
import re

Newlines = re.compile(r'[\r\n]\s+')

def getPageText(url):
    # given a url, get page content
    data = urllib2.urlopen(url).read()
    # parse as html structured document
    bs = BeautifulSoup.BeautifulSoup(data, convertEntities=BeautifulSoup.BeautifulSoup.HTML_ENTITIES)
    # kill javascript content
    for s in bs.findAll('script'):
        s.replaceWith('')
    # find body and extract text
    txt = bs.find('body').getText('\n')
    # remove multiple linebreaks and whitespace
    return Newlines.sub('\n', txt)

def main():
    urls = [
        'https://www.nasdaq.com/symbol/fb',
        'https://www.nasdaq.com/symbol/aapl',
        'https://www.nasdaq.com/symbol/amzn',
        'https://www.nasdaq.com/symbol/nflx',
        'https://www.nasdaq.com/symbol/GOOGL'
    ]
    text_file = open("Data.txt","w")
    
    txt = [getPageText(url) for url in urls]
    for i in txt:
        text_file.write(i)
        text_file.write("\n")
        text_file.write("----")
        text_file.write("\n")
    text_file.close()


if __name__=="__main__":
    main()
