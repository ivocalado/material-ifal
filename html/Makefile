SOURCE = html

all: PDF
	evince $(SOURCE).pdf &
clean:
	rm $(SOURCE).aux $(SOURCE).log $(SOURCE).nav $(SOURCE).out $(SOURCE).pdf $(SOURCE).snm $(SOURCE).toc $(SOURCE).vrb $(SOURCE).tex~
PDF:
	pdflatex -interaction=nonstopmode $(SOURCE).tex
	pdflatex -interaction=nonstopmode $(SOURCE).tex
	pdflatex -interaction=nonstopmode $(SOURCE).tex

