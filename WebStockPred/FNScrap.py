#BeautifulSoup and Requests are needed
posWords = ['first','better','develop','lets you', 'new','product','love','built','sale','getting','fast','adding','will support','donation',
'good','good news']
negWords = ['fraud','fined','left','trouble','nervous',' shutting down','scam','harms','expensive','costly','shrinks','decrease','bad','bad news',
'awful','alarming','contradictory','dishonorable','dirty','faulty','hostile','malicious','offensive','oppressive']
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
        'https://www.theverge.com/search?q=facebook',
        'https://www.theverge.com/search?q=apple',
        'https://www.theverge.com/search?q=amazon',
        'https://www.theverge.com/search?q=netflix',
        'https://www.theverge.com/search?q=google'
    ]
    txt = [getPageText(url) for url in urls]
    for i in txt:
        print(i)
        print("\n")
        print("----")
        print("\n")
        


if __name__=="__main__":
    main()
