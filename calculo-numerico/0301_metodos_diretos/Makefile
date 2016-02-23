SOURCE = 0301_metodos_diretos

all: PDF
	evince $(SOURCE).pdf &
clean:
	rm $(SOURCE).aux $(SOURCE).log $(SOURCE).nav $(SOURCE).out $(SOURCE).snm $(SOURCE).toc $(SOURCE).vrb
PDF:
	pdflatex -interaction=nonstopmode $(SOURCE).tex
	pdflatex -interaction=nonstopmode $(SOURCE).tex
	pdflatex -interaction=nonstopmode $(SOURCE).tex

