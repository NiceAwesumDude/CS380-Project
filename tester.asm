

.data
array byte 10, 11, 12
.code
main PROC

mov eax,0
mov al,array
call writedec

call crlf

mov al,[array + 2]
call writedec

                        
                        exit
main ENDP

END main
