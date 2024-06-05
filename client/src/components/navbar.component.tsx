import { cn } from '@lib/utils'
import { useLocale, useTranslations } from 'next-intl'
import Link from 'next/link'
import NavUserProfile from './navbar/nav-user-profile.component'

type NavLink = { name: 'home' | 'search'; href: string }

const navLinks: NavLink[] = [
  { name: 'home', href: '/' },
  { name: 'search', href: '/search' },
]

const Navbar = () => {
  const t = useTranslations('nav.links')
  const activeLocale = useLocale()

  return (
    <div className="flex h-16 items-center px-4">
      <nav className={cn('mx-6 flex items-center space-x-4 lg:space-x-6')}>
        {navLinks.map((link) => (
          <Link
            key={link.name}
            href={'/' + activeLocale + link.href}
            className="text-sm font-medium transition-colors hover:text-primary"
          >
            {t(link.name)}
          </Link>
        ))}
      </nav>
      <div className="ml-auto flex items-center space-x-4">
        <NavUserProfile />
      </div>
    </div>
  )
}
export default Navbar
